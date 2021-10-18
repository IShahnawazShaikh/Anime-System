import React, { Component } from 'react';
import Header from './Componets/Header/Header';
import Movies from './Componets/Movies/Movies';

import MoviePage from './Componets/MoviePage/MoviePage';
import Profile from './Componets/profile/Profile';
import axios from "axios";

import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Login from './Componets/Login/login';
import Signup from './Componets/Register/register';
import {UserProvider} from './Componets/Context/UserContext'
class App extends Component {
  state = {
    animeData:[]
  }
  async componentDidMount() { 
    let data2 = await axios.get(`https://api.aniapi.com/v1/anime?genres=Ninja`)
  
    let animeData=data2.data.data.documents;

    // console.log("front") 
    // console.log(animeData);

    this.setState({
      animeData:animeData
    });

  }
  setMovies = async (newMovieName) => {
   let data2=await axios.get(`https://api.aniapi.com/v1/anime?genres=${newMovieName}`);
   
    let animeData=data2.data.data.documents;
    // alert(animeData);
    this.setState({
      animeData: animeData
    });
  }

  requireAuth(nextState, replace, next) {
    if (localStorage.getItem("email")==undefined) {
      replace({
        pathname: "/login",
        state: {nextPathname: nextState.location.pathname}
      });
    }
    next();
  }

  render() {
    return (
      <Router>
        <div className="App">
          <Header setMovies={this.setMovies}></Header>
          <Switch>
            <Route path="/" exact>
              {this.state.animeData.length ?
                (<React.Fragment>
                  <Movies movies={this.state.animeData}></Movies>
                  
                </React.Fragment>
                ) : (
                  <h1>Loading...</h1>
                )
              }
            </Route>
            <UserProvider>
              <Route path="/moviepage" exact component={MoviePage} ></Route>
              <Route path="/login" exact component={Login}></Route>
              <Route path="/register" exact component={Signup}></Route>
              <Route path="/profile" exact component={Profile}></Route>
            </UserProvider>

            </Switch>
       
        </div>
      </Router>
    );
  }
}

export default App;