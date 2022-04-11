import React from "react";
import "./Header.css";

const Header = () => {
  return (
    <div className="header">
      <a href="/" className="logo">
        Letter Box
      </a>
      <div className="header-right">
        <a href="/movies">Movies</a>
        <a href="/movies/search">Search</a>
        <a href="/movies/search">Lists</a>
        <a href="/members">Members</a>
        <a href="/about">About</a>
      </div>
    </div>
  );
};

export default Header;
