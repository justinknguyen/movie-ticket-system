import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Container from "@mui/material/Container";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";
import { useState, useEffect } from "react";
import { flexbox } from "@mui/system";
import { userInfo } from "./Login.js";
import { globalTickets } from "./Payment.js";

export default function Account() {
	const [tickets,setTickets] = useState([])

	const paperStyle = {
		padding: "50px 20px",
		width: 600,
		margin: "20px auto",
	};

	useEffect(()=>{
		fetch("http://localhost:8080/api/v1/ticket/all")
		.then(res=>res.json())
		.then(result=>{
		  setTickets(result);
		})
	  },[])

	return (
		<Container>
			<Paper elevation={3} style={paperStyle}>
			<h1>Account Information</h1>
				<Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} >
					ID:{userInfo.id} <br></br>
					Email Address:{userInfo.email} <br></br>
					Password:{userInfo.password} <br></br>
					Name:{userInfo.name} <br></br>
					Address:{userInfo.address} <br></br>
					Date Registered:{userInfo.dateRegistered} <br></br>
				</Paper>
			</Paper>

			<Paper elevation={3} style={paperStyle}>
			<h1>Tickets</h1>
			{tickets.map((ticket) =>(
        
				<Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={ticket.id}>
				Theatre:{ticket.theatre} <br></br>
				Movie:{ticket.movie} <br></br>
				Showtime:{ticket.showtime}
				</Paper>

			))}
			</Paper>
		</Container>
	);
}
