import axios from "axios";
import React, { Component } from "react";

import "./MoviePage.css";

class MoviePage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      reviews: "",
      existingReviews: [],
    };
    this.handleReview = this.handleReview.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleSubmit(e) {
    e.preventDefault();
     if(localStorage.getItem("email")==undefined){
        
       this.props.history.push("/login")
       
     }

    else{
    
      const data = {
        animeId: this.props.location.state.id,
        userId: "1543",
        reviews: this.state.reviews,
      };
      axios
        .post("http://localhost:8200/reviews/add", data)
        .then(function (response) {
          if (response) {
            alert("success");
            console.log(response);
          } else {
            alert("failure");
            console.log(response);
          }
        })
        .catch(function (error) {
          console.log(error);
        });  
    }
  }

  handleReview(e) {
    this.setState({ reviews: e.target.value });
    console.log("reviews", e.target.value);
  }

  async componentDidMount() {
    let response = await axios.get(
      `http://localhost:8200/reviews/${this.props.location.state.id}`
    );

    console.log("query", response.data);
    let data = response.data;
    this.setState({
      existingReviews: data,
    });
  }
  render() {
    const opts = {
      height: "100%",
      width: "100%",
      playerVars: {
        autoplay: 1,
      },
    };

    //console.log(this.props);
    let {
      id,
      titles,
      descriptions,
      score,
      banner_image,
      episodes_count,
      genres,
      season_year,
    } = this.props.location.state;
    //console.log(this.props.location.state);
    //console.log(titles.en);
    let reviews = "";
    return (
      <div className="movie-page">
        <div className="movie-page-details">
          <div className="movie-page-poster">
            <img src={banner_image} alt="" />
          </div>
          <div className="movie-title-info">
            <h1>
              {titles.en} {titles.jp}
              <br></br>
            </h1>
            <h3>{score} IMDB</h3>
            <p>Description : {descriptions.en}</p>
            <div>
              Genres:{" "}
              {genres.map((genre) => {
                return <span>{genre}, </span>;
              })}
            </div>
            <h6>Season Year: {season_year}</h6>
            <h6>episodes_count : {episodes_count}</h6>
          </div>

          <div className="reviews">
            <div>
              {" "}
              Comments:
              {this.state.existingReviews.map((user) => (
                <h5>{`${user.reviews}`}</h5>
              ))}
            </div>
            <form onSubmit={this.handleSubmit} action="localhost:8200/reviews/add" method="POST">
              <p>Add your reviews Reviews</p>
              <textarea
                type="textarea"
                value={this.state.reviews}
                onChange={this.handleReview}
              />
              <br></br>
              <br></br>
              <input type="submit" value="Submit" />
              <br></br>
              <br></br>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

export default MoviePage;
