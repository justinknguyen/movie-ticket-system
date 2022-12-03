import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Container from '@mui/material/Container'
import Paper from '@mui/material/Paper'
import Button from '@mui/material/Button'
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { useNavigate } from "react-router-dom";
import { theatreSelected } from "./Theatres.js";
import { movieSelected } from "./Movies.js";
import { stSelected } from "./Showtimes.js";
import { userInfo } from "./Login.js";

export default function Seats() {
  const nav = useNavigate();
  const paperStyle = {padding:'50px 20px', width:600, margin:'20px auto'}
  const [seats,setSeats] = useState([])
  const [createdTicket,setTicket] = useState(undefined)
  const [createdSeat,setSeat] = useState(undefined)

  const [tId,settId] = useState('')
  const [mId,setmId] = useState('')
  const [stId,setstId] = useState('')
  const [isError, setIsError] = useState(false);
  const [isSubmitted, setIsSubmitted] = useState(false);
  const [isSubmitted2, setIsSubmitted2] = useState(false);

  function sortByKey(array, key) {
		return array.sort(function (a, b) {
			var x = Number(a[key]);
			var y = Number(b[key]);
			return x < y ? -1 : x > y ? 1 : 0;
		});
	}

  // load seats
  useEffect(()=>{
    console.log(stSelected.sId)
    fetch("http://localhost:8080/api/v1/theatres/"+theatreSelected.tId+"/movies/"+movieSelected.mId+
          "/showtimes/"+stSelected.sId+"/seats")
    .then(res=>res.json())
    .then(result=>{
      setSeats(sortByKey(JSON.parse(JSON.stringify(result)), "id"));
    })
  },[])

  // add ticket to user
  useEffect(()=>{
    console.log(createdTicket)
    if (createdTicket !== undefined){
      fetch("http://localhost:8080/api/v1/registereduser/"+createdTicket.id+"/add/"+userInfo.email, {
        method: "PUT",
        headers: { "Content-Type": "application/json" }
      })
        .then(() => {
          console.log("Ticket Added to User");
          setIsSubmitted(true);
          setIsError(false);
          nav("/movie-ticket-system/payment");
        })
        .catch(() => {
          console.log("err2");
          setIsError(true);
          setIsSubmitted(false);
        })
    }
  },[createdTicket]);

  // get last created ticket
  useEffect(()=>{
    if (isSubmitted2 === true) {
      fetch("http://localhost:8080/api/v1/ticket/all")
      .then(res=>res.json())
      .then(result=>{
          setTicket(result[result.length-1]);
      })
    }
  },[isSubmitted2]);

  const clickHandle = (e, i) =>{
    e.preventDefault()
    const seatSelected = seats[i].letter_row + seats[i].number_row
    const ticket={
      theatre: theatreSelected.name, 
      movie: movieSelected.name, 
      showtime: stSelected.showtime, 
      seat: seatSelected, 
      price: 10.00}
    console.log(ticket)
    // create ticket
    fetch("http://localhost:8080/api/v1/ticket/add", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(ticket),
        })
          .then(() => {
            console.log(ticket);
            console.log("Ticket Created");
            setIsSubmitted2(true);
            setIsSubmitted(true);
            setIsError(false);
          })
          .catch(() => {
            console.log("err1");
            setIsError(true);
            setIsSubmitted(false);
          });

    // change seat status to occupied
    fetch("http://localhost:8080/api/v1/seat/reserveSeat/"+seats[i].id, {
      method: "PUT",
      headers: { "Content-Type": "application/json" }
    })
      .then(() => {
        console.log("Seat is now occupied");
        setIsSubmitted(true);
        setIsError(false);
      })
      .catch(() => {
        console.log("err");
        setIsError(true);
        setIsSubmitted(false);
      })
  }

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
      <h1>Seats</h1>
      
        {seats.map((seat,i)=>(
          <div>
          {seat.reserved ? (
                <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={seat.id}>
                  ID:{seat.id},
                  Seat:{seat.letter_row+seat.number_row} <br></br>
                  Status:{seat.reserved ? 'Occupied' : 'Empty'}
                </Paper>
          ) : (
            <Link onClick={(e) => clickHandle(e, i)}>
              <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={seat.id}>
                ID:{seat.id},
                Seat:{seat.letter_row+seat.number_row} <br></br>
                Status:{seat.reserved ? 'Occupied' : 'Empty'}
              </Paper>
            </Link>
          )}
          </div>
        ))}
      </Paper>
     
    </Container>
  );
}
