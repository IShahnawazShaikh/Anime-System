import React, { Component } from 'react';
import "./profile.css";
class Profile extends Component {

    constructor(props) {
        super(props);
        this.signOut = this.signOut.bind(this);
      }
    
      signOut() {
        localStorage.removeItem("email");
        this.props.history.push('/');

        
      }
    render() { 

        return ( 
            <div className="signout-button">
               <button onClick={this.signOut}>SignOut</button>
            </div>
         );
    }
}
 
export default Profile;