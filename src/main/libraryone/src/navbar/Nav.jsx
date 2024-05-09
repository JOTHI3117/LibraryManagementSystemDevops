import React from "react";
import "./nav.css";
import { Link } from "react-router-dom";

export default function Nav() {
  return (
    <div>
      <nav>
        <label  class="logo">Jupiter Library</label>
        <ul>
          <li>
            {" "}
            <Link to="/"  class="active">
             
                Book Details
             
            </Link>
          </li>

          <li>
            <Link to="/borrow" id="borrow">
             Book Borrow Details
            </Link>
          </li>
          
        </ul>
      </nav>
    </div>
  );
}
