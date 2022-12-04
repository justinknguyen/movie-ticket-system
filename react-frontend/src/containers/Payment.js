import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Container from '@mui/material/Container'
import Paper from '@mui/material/Paper'
import Button from '@mui/material/Button'
import { useState, useEffect } from 'react';
import { userInfo } from "./Login.js";
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import Checkbox from '@mui/material/Checkbox';
var totalPrice = 0.00;


export default function Payment() {
  const paperStyle = {padding:'50px 20px', width:600, margin:'20px auto'}
  const [isError, setIsError] = useState(false);
  const [isSubmitted, setIsSubmitted] = useState(false);
  const [cardNo,setCardNo] = useState('')
  const [expiry,setExpiry] = useState('')
  const [cvv,setCvv] = useState('')
  const [name,setName] = useState('')
  const [price,setPrice] = useState('')

  const [tickets,setTickets] = useState([])
  const [checked, setChecked] = useState([]);

  function sortByKey(array, key) {
		return array.sort(function (a, b) {
			var x = Number(a[key]);
			var y = Number(b[key]);
			return x < y ? -1 : x > y ? 1 : 0;
		});
	}

  useEffect(()=>{
    fetch("http://localhost:8080/api/v1/registereduser/tickets"+userInfo.email)
    .then(res=>res.json())
    .then(result=>{
      setTickets(sortByKey(JSON.parse(JSON.stringify(result)), "id"));
    })
  },[])

  useEffect(()=>{
    totalPrice = tickets.length * 10;
    setPrice(totalPrice);
    console.log(tickets.length);
  },[tickets])

  const handleClick=(e)=>{
    e.preventDefault()
    const creditCard={cardNo, expiry, cvv, name}
    console.log(creditCard)
    // TODO: send data to database
    fetch(`http://localhost:8080/api/v1/payment/addPayment/${cardNo}/${price}`,
        {
          method:"PUT",
          headers:{"Content-Type":"application/json"},
          body:JSON.stringify(creditCard)
        }).then(()=>{
      console.log("Payment Successful")
      setIsSubmitted(true);
      setIsError(false);
    }).catch(()=>{
      console.log("Error")
      setIsError(true);
      setIsSubmitted(false);
    })
  }

  const handleDelete = (e) => {
    const id = [];
    for (var i = 0; i < checked.length; i++) {
      id.push(tickets[checked[i]].id);
    }
    console.log(id)

    for (var i = 0; i < id.length; i++) {
    fetch("http://localhost:8080/api/v1/ticket/delete/"+id[i], {
        method: "DELETE",
        headers: { "Content-Type": "application/json" }
      })
        .then(() => {
          console.log("Ticket Deleted From User");
          setIsSubmitted(true);
          setIsError(false);
          fetch("http://localhost:8080/api/v1/registereduser/tickets"+userInfo.email)
            .then(res=>res.json())
            .then(result=>{
              setTickets(sortByKey(JSON.parse(JSON.stringify(result)), "id"));
              setChecked([]);
            })
        })
        .catch(() => {
          console.log("err2");
          setIsError(true);
          setIsSubmitted(false);
        })
      }
  };

  const handleToggle = (value) => () => {
    const currentIndex = checked.indexOf(value);
    const newChecked = [...checked];
    if (currentIndex === -1) {
      newChecked.push(value);
    } else {
      newChecked.splice(currentIndex, 1);
    }
    setChecked(newChecked);
  };

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
      <h1>Ticket Cart</h1>
        {tickets.map((ticket,i) =>( 
          <ListItemButton role={undefined} onClick={handleToggle(i)} key={ticket.id} dense>
            <ListItemIcon>
                <Checkbox
                  edge="start"
                  checked={checked.indexOf(i) !== -1}
                  tabIndex={-1}
                  disableRipple
                />
              </ListItemIcon>
            <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}}>
              ID:{ticket.id} <br></br>
              Theatre:{ticket.theatre} <br></br>
              Movie:{ticket.movie} <br></br>
              Showtime:{ticket.showtime} <br></br>
              Seat:{ticket.seatDesc}
            </Paper>
          </ListItemButton>
          ))}
          <br></br>
          <Box textAlign='center'>
            <Button variant="contained" onClick={handleDelete}>
              Delete
            </Button>
          </Box>
      </Paper>

      <Paper elevation={3} style={paperStyle}>
        <h1>Payment</h1>
        <p>Your total is ${totalPrice}.00</p>

    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: 500, maxWidth: '100%' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField required id="outlined-required" label="Credit Card Number" variant="outlined" fullWidth
      value = {cardNo}
      onChange={(e)=>setCardNo(e.target.value)}
      />
      <TextField required id="outlined-required" label="Expiry Date (MM/YY)" variant="outlined" fullWidth
      value = {expiry}
      onChange={(e)=>setExpiry(e.target.value)}
      />
      <TextField required id="outlined-required" label="CVV" variant="outlined" fullWidth
      value = {cvv}
      onChange={(e)=>setCvv(e.target.value)}
      />
      <TextField required id="outlined-required" label="Cardholder Name" variant="outlined" fullWidth
      value = {name}
      onChange={(e)=>setName(e.target.value)}
      />
      
      <Button variant="contained" onClick={handleClick}>
        Submit
      </Button>
    </Box>
    </Paper>

      <Paper elevation={3} style={paperStyle}>
        <h1>Response</h1>
        {isSubmitted ? <div>Payment Successful! Please check your email.</div> : 
                        <div></div>}
        {isError ? <div>Error. Please try again.</div> : 
                        <div></div>}
      </Paper>
    </Container>
  );
}
