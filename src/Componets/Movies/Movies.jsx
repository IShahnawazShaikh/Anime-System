import React, { Component } from 'react';
import Movie from '../Movie/Movie';
import "./Movies.css";
class Movies extends Component {
    state = {  }
    render() { 

        return ( 
            <div className="Movies">
                {   
                    this.props.movies.map((animeObject)=>{
                       return <Movie movie={animeObject}> </Movie>;
                    })
                }
            </div>
         );
    }
}
 
export default Movies;