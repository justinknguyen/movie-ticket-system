import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Container from '@mui/material/Container'
import Paper from '@mui/material/Paper'
import Button from '@mui/material/Button'
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { theatreSelected } from "./Theatres.js";
import { movieSelected } from "./Movies.js";
export var stSelected = undefined;

export default function Showtimes() {
  const paperStyle = {padding:'50px 20px', width:600, margin:'20px auto'}
  const [isError, setIsError] = useState(false);
  const [isSubmitted, setIsSubmitted] = useState(false);
  const [showtimes,setShowtimes] = useState([])
  const [tId,settId] = useState('')
  const [mId,setmId] = useState('')

  useEffect(()=>{
    fetch("http://localhost:8080/api/v1/theatres/"+theatreSelected+"/movies/"+movieSelected+"/showtimes/")
    .then(res=>res.json())
    .then(result=>{
      setShowtimes(result);
    })
  },[])

  const clickHandle = (i) =>{
    stSelected = showtimes[i].showtime;
    console.log(stSelected);
  }

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
      <h1>Showtimes</h1>
        {showtimes.map((showtime,i)=>(
        <Link to={'/movie-ticket-system/seats'} onClick={() => clickHandle(i)}>
          <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={showtime.showtime}>
            ID:{showtime.stId},
            Start Time:{showtime.showtime}
          </Paper>
        </Link>
        ))}
      </Paper>
     
    </Container>
  );
}
