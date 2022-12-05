import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Container from "@mui/material/Container";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";
import { useState, useEffect } from "react";
import { flexbox } from "@mui/system";
import { userInfo } from "./AdminLogin.js";
import { globalTickets } from "./Payment.js";
import { useNavigate } from "react-router-dom";
import Axios from "axios";

export default function Admin() {

	const navigate = useNavigate()

	const [movies,setMovies] = useState([])
	const [staff,setStaff] = useState([])
	const [users,setUsers] = useState([])

	const [staffId,setStaffId] = useState([])
	const [userId,setUserId] = useState([])
	const [movieId,setMovieId] = useState([])

	const [Name,setName] = useState([])
	const [Email,setEmail] = useState([])
	const [Password,setPassword] = useState([])

	const [Response,setResponse] = useState([])

	const paperStyle = {
		padding: "50px 20px",
		width: 600,
		margin: "20px auto",
	};

	async function getMovies() {
		const response = await fetch("http://localhost:8080/api/v1/admin/allMovies")
        const data = await response.json()
		setMovies(data)
	}

	async function getStaff() {
		const response = await fetch("http://localhost:8080/api/v1/admin/allStaff")
        const data = await response.json()
		setStaff(data)
	}

	async function getUsers() {
		const response = await fetch("http://localhost:8080/api/v1/admin/allRegisteredUsers")
        const data = await response.json()
		setUsers(data)
	}

	useEffect(()=>{ 
		getMovies()
		getStaff()
		getUsers()
	  },[]);


	async function addStaffFunc() {
		console.log("Adding staff")
		var body = {name: Name, email: Email, password: Password}
		// console.log(body)
		const options = {
			method: 'POST',
			headers: {'Content-Type': 'application/json'},
			body: JSON.stringify(body)
		}
		fetch('http://localhost:8080/api/v1/admin/addAdminStaff', options)
		.then((response) => {
			console.log(response)
			document.getElementsByName('display')[0].value= response
		  })

		.then(getStaff())
	}

	const addStaff=(e)=>{e.preventDefault()
		addStaffFunc()
	}

	async function removeStaffFunc() {
		var body = staff.find(item => item.id === Number(staffId));
		console.log(body)
		const options = {
			method: 'DELETE',
			headers: {'Content-Type': 'application/json'},
			body: JSON.stringify(body)
		}
		const response = await fetch('http://localhost:8080/api/v1/admin/removeAdminStaff', options)
		document.getElementsByName('display')[0].value= response
		getStaff()
	}

	const removeStaff=(e)=>{e.preventDefault()
		removeStaffFunc()
	}


	const addUser=(e)=>{e.preventDefault()
        // addCourse()
    }
	
	const removeUser=(e)=>{e.preventDefault()
        // addCourse()
    }

	const addMovie=(e)=>{e.preventDefault()
        // addCourse()
    }
	
	const removeMovie=(e)=>{e.preventDefault()
        // addCourse()
    }

	return (
		<Container>
			<Paper elevation={3} style={paperStyle}>
			<h1>Account Information</h1>
				<Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} >
					Id:{userInfo.id} <br></br>
					Email Address:{userInfo.email} <br></br>
					Password:{userInfo.password} <br></br>
					Name:{userInfo.name} <br></br>
				</Paper>
			</Paper>

			<Paper elevation={3} style={paperStyle}>
			<h1>Movies</h1>
			{movies.map((movie) =>(
        
				<Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={movie.mId}>
				Id:{movie.mId} <br></br>
				Movie:{movie.name} <br></br>
				</Paper>

			))}

			<br/><br/>
			<input type="text" placeholder="Movie Id" 
            value={movieId} 
            onChange={(e)=>setMovieId(e.target.value)}/>
			<button onClick={addMovie} > Add Movie </button>
			<button onClick={removeMovie} > Remove Movie </button>
			<br/><br/>

			</Paper>

			<Paper elevation={3} style={paperStyle}>
			<h1>Staff</h1>
			{staff.map((staffMember) =>(
        
				<Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={staffMember.id}>
				Id:{staffMember.id} <br></br>
				Name:{staffMember.name} <br></br>
				Email:{staffMember.email} <br></br>
				</Paper>

			))}
			
			<br/><br/>
			<input type="number" placeholder="Staff Id" 
            value={staffId} 
            onChange={(e)=>setStaffId(e.target.value)}/>
			<button onClick={removeStaff} > Remove Staff </button>
			<br/><br/>

			<input type="text" placeholder="Name" 
            value={Name}
            onChange={(e)=>setName(e.target.value)}/>
			<input type="text" placeholder="Email" 
            value={Email}
            onChange={(e)=>setEmail(e.target.value)}/>
			<input type="text" placeholder="Password" 
            value={Password}
            onChange={(e)=>setPassword(e.target.value)}/>

			<button onClick={addStaff} > Add Staff </button>
			<br/><br/>
			<label htmlFor="displayValue"> Output: </label>
            <input type="textarea" name="display"></input>

			</Paper>

			<Paper elevation={3} style={paperStyle}>
			<h1>Registered Users</h1>
			{users.map((user) =>(
        
				<Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={user.id}>
				Id:{user.id} <br></br>
				Name:{user.name} <br></br>
				Email:{user.email} <br></br>
				</Paper>

			))}

			<br/><br/>
			<input type="text" placeholder="User Id" 
            value={userId} 
            onChange={(e)=>setUserId(e.target.value)}/>
			<button onClick={addUser} > Add User </button>
			<button onClick={removeUser} > Remove User </button>
			<br/><br/>

			</Paper>

		</Container>
	);
}
