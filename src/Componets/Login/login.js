import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import axios from "axios";
import { Link } from 'react-router-dom';


const useStyles = makeStyles(theme => ({
    root: {
    
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        marginTop:'100px',
        padding: theme.spacing(2),

        '& .MuiTextField-root': {
            backgroundColor:'white',
            margin: theme.spacing(1),
            width: '300px',
        },
        '& .MuiButtonBase-root': {
            margin: theme.spacing(2),
        },
    },
}));

const Login = (props) => {
    const classes = useStyles();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = e => {
        e.preventDefault();
    console.log(email, password);
    const data =  {
        email: email,
        password: password
      };
      axios.post('http://localhost:8200/user/login', data)
      .then(function (response) {
        if (response) {
          
          alert('success')

          localStorage.setItem('email',response.data.email)
          localStorage.setItem('fname', response.data.firstName)
          localStorage.setItem('lname', response.data.lastName)

          props.history.push('/')
        } else{
          alert('failure')
          console.log("response: ",response);  
        }
        
      })
      .catch(function (error) {
        console.log(error);
      });

        
    };

    return (
        <div>
        <form className={classes.root} onSubmit={handleSubmit}>
            <TextField
                label="Email"
                variant="filled"
                type="email"
                required
                value={email}
                onChange={e => setEmail(e.target.value)}
            />
            <TextField
                label="Password"
                variant="filled"
                type="password"
                required
                value={password}
                onChange={e => setPassword(e.target.value)}
            />
            <div>
                <Button type="submit" variant="contained" color="primary">
                    Login
                </Button>
            </div>
            <div> Don't have acoount ?  <Link to="/register">Register</Link></div>
        </form>
          
        </div>
    );
};

export default Login;