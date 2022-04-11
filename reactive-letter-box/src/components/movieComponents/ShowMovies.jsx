import React, { useEffect, useState } from "react";
import MovieService from "../../services/MovieService";
import "./movies.css";

const ShowMovies = () => {
  const [movies, setMovies] = useState([]);
  useEffect(() => {
    MovieService.getAllMovies().then((res) => {
      setMovies(res.data);
    });
  });
  return (
    <div>
      <div>
        <h2 className="text-centre">Movie List</h2>
        <div className="row">
          <table id="movies">
            <thead>
              <tr>
                <th>Movie</th>
                <th>Director</th>
                <th>Language</th>
                <th>Rating</th>
              </tr>
            </thead>
            <tbody>
              {movies.map((movies) => (
                <tr key={movies.name}>
                  <td>{movies.name}</td>
                  <td>{movies.director}</td>
                  <td>{movies.lang}</td>
                  <td>{movies.rating}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default ShowMovies;
