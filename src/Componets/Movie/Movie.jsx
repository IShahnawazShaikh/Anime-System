
import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import "./Movie.css";
class Movie extends Component {
    state = { 
        animeId:"1"
     }

   async componentDidMount() {
    //  console.log(this.props.movie.id);
    this.setState({
      animeId:this.props.movie.id,
    });
  }


    render() { 
       let {cover_image,titles,episodes_count,id}=this.props.movie;
        return ( 
           <div className="movie-item">
               <div className="movie-poster">
               <Link to={{pathname:"/moviepage", state:this.props.movie}}>    
                 <img src={cover_image} alt=""/>
              </Link>
                   
               </div>
               <div className="movie-info">
                   <div className="movie-title">{titles.en}</div>
                   <div className="movie-rating">{episodes_count}</div>
               </div>
           </div>
         );
    }
}
 
export default Movie;