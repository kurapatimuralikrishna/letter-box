import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import MovieService from "../../services/MovieService";

const ShowMovie = () => {
  let { mname } = useParams();
  const [movie, setMovie] = useState([]);
  useEffect(() => {
    MovieService.getMovie(mname).then((res) => {
      setMovie(res.data);
    });
  });
  return (
    <div>
      <h2>{mname}</h2>
      <p>{movie.director}</p>
      <p>{movie.lang}</p>
      <p>{movie.rating}</p>
    </div>
  );
};

export default ShowMovie;
