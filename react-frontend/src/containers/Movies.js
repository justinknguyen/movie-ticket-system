import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Container from '@mui/material/Container'
import Paper from '@mui/material/Paper'
import Button from '@mui/material/Button'
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

export default function Movies() {
  const paperStyle = {padding:'50px 20px', width:600, margin:'20px auto'}
//   const [movies,setMovies] = useState([])
  const [movies,setMovies] = useState(['Interstellar', 'Cars 2'])
  const [tId,settId] = useState('')

  useEffect(()=>{
    fetch("http://localhost:8080/api/v1/theatres/"+tId+"/movies")
    .then(res=>res.json())
    .then(result=>{
      setMovies(result);
    })
  },[])

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
      <h1>Movies</h1>
        {movies.map(movie=>(
        <Link to={'/movie-ticket-system/showtimes'}>
          <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={movie.id}>
            {/* Name:{movie.name} */}
                {movie}
          </Paper>
        </Link>
        ))}
      </Paper>
     
    </Container>
  );
}
