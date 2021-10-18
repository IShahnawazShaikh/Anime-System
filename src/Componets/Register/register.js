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

const Signup = () => {
    const classes = useStyles();
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = e => {
        e.preventDefault();
        console.log(firstName, lastName, email, password);
        const data =  {
            firstName:firstName,
            lastName,lastName,
            email: email,
            password: password 
          }
          axios.post('http://localhost:8200/user/register', data)
          .then(function (response) {
            if (response) {
              alert('success')
              console.log(response);
              this.props.history("/login");

            } else{
              alert('failure')
              console.log(response);  
            }
          })
          .catch(function (error) {
            console.log(error);
          });



    };

    return (
        <form className={classes.root} onSubmit={handleSubmit}>
            <TextField
                label="First Name"
                variant="filled"
                required
                value={firstName}
                onChange={e => setFirstName(e.target.value)}
            />
            <TextField
                label="Last Name"
                variant="filled"
                required
                value={lastName}
                onChange={e => setLastName(e.target.value)}
            />
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
                    Signup
                </Button>

            </div>
            <div>Already have acoount ? <Link to="/login">Login</Link></div>
        </form>
    );
};

export default Signup;