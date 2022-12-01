import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Container from '@mui/material/Container'
import Paper from '@mui/material/Paper'
import Button from '@mui/material/Button'
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

export default function Showtimes() {
  const paperStyle = {padding:'50px 20px', width:600, margin:'20px auto'}
  const [showtimes,setShowtimes] = useState([])
  const [tId,settId] = useState('')
  const [mId,setmId] = useState('')

  useEffect(()=>{
    fetch("http://localhost:8080/api/v1/showtimes")
    .then(res=>res.json())
    .then(result=>{
      setShowtimes(result);
    })
  },[])

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
      <h1>Showtimes</h1>
        {showtimes.map(showtime=>(
        <Link to={'/movie-ticket-system/seats'}>
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