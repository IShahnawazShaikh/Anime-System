import React, { Component } from 'react';
import {Link} from "react-router-dom";
import "./Header.css"
class Header extends Component {
    state = { 
        newMovieName:""
     }
     handleOnChange=(e)=>{
       let value=e.target.value;
       this.setState({
           newMovieName:value
       })
     };
     handleOnKeyPress=(e)=>{
        if(e.key==="Enter"){
            this.props.setMovies(this.state.newMovieName);
        }
     };
    render() { 
        return ( 
            <div className="header">
                <div className="logo">
                    <img src="logo.svg" alt="" />
                </div>
                <div className="search-btn">
                    <input type="text" className="search-movie" placeholder="Search" value={this.state.newMovieName}  onChange={this.handleOnChange} onKeyPress={this.handleOnKeyPress}/>
                </div>
                <div className="header-links">
                    <div className="header-link">
                        <Link to="/">Home</Link>
                    </div>
                    <div className="header-link">
                        {localStorage.getItem("email")==undefined?
                        <Link to="/login"> Login</Link>
                        :<Link to="/profile"> Profile</Link>}
                    </div>
                </div>
            </div>
            
         );
    }
}
 
export default Header;