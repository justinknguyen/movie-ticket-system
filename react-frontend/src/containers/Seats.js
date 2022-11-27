import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Container from '@mui/material/Container'
import Paper from '@mui/material/Paper'
import Button from '@mui/material/Button'
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

export default function Seats() {
  const paperStyle = {padding:'50px 20px', width:600, margin:'20px auto'}
//   const [seats,setSeats] = useState([])
  const [seats,setSeats] = useState(['Seat 1', 'Seat 2'])
  const [tId,settId] = useState('')
  const [mId,setmId] = useState('')
  const [stId,setstId] = useState('')

  useEffect(()=>{
    fetch("http://localhost:8080/api/v1/theatres/"+tId+"/movies/"+mId+"/showtimes/"+stId+"/seats")
    .then(res=>res.json())
    .then(result=>{
      setSeats(result);
    })
  },[])

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
      <h1>Seats</h1>
        {seats.map(seat=>(
        <Link to={'/movie-ticket-system/payment'}>
          <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={seat.id}>
            {/* Name:{seat.name} */}
                {seat}
          </Paper>
        </Link>
        ))}
      </Paper>
     
    </Container>
  );
}
