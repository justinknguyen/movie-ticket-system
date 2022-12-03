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

export default function Seats() {
  const nav = useNavigate();
  const paperStyle = {padding:'50px 20px', width:600, margin:'20px auto'}
  const [seats,setSeats] = useState([])
  // const [seats,setSeats] = useState(['Seat 1', 'Seat 2'])
  const [tId,settId] = useState('')
  const [mId,setmId] = useState('')
  const [stId,setstId] = useState('')
  const [isError, setIsError] = useState(false);
  const [isSubmitted, setIsSubmitted] = useState(false);

  useEffect(()=>{
    fetch("http://localhost:8080/seat")
    .then(res=>res.json())
    .then(result=>{
      setSeats(result);
    })
  },[])

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
    // TODO: send data to database
    fetch("http://localhost:8080/api/v1/ticket/add", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(ticket),
        })
          .then(() => {
            console.log(ticket);
            console.log("Ticket Created");
            setIsSubmitted(true);
            setIsError(false);
            nav("/movie-ticket-system/payment");
          })
          .catch(() => {
            console.log("Error");
            setIsError(true);
            setIsSubmitted(false);
          });
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
