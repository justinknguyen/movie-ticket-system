import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Container from '@mui/material/Container'
import Paper from '@mui/material/Paper'
import Button from '@mui/material/Button'
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
export var movieSelected = undefined;

export default function Movies() {
  const paperStyle = {padding:'50px 20px', width:600, margin:'20px auto'}
  const [movies,setMovies] = useState([])
  const [tId,settId] = useState('')

  useEffect(()=>{
    fetch("http://localhost:8080/api/v1/movies")
    .then(res=>res.json())
    .then(result=>{
      setMovies(result);
    })
  },[])

  const clickHandle = (i) =>{
    movieSelected = movies[i].name;
    console.log(movieSelected)
  }

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
      <h1>Movies</h1>
        {movies.map((movie,i) =>(
        <Link to={'/movie-ticket-system/showtimes'} onClick={() => clickHandle(i)}>
          <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={movie.mId}>
            ID:{movie.mId},
            Name:{movie.name} <br></br>
            Release Date:{movie.releaseDate}
          </Paper>
        </Link>
        ))}
      </Paper>
     
    </Container>
  );
}
