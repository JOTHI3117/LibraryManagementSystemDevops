import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import axios from "axios";
// import {  useNavigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.css";

export default function Borrow() {
  const [borrow, setBorrow] = useState([]);
  // const navigate = useNavigate();
  // const [borrowed, setBorrowed] = useState({
  //   borrowId: " ",
  //   borrowDate: " ",
  //   returnDate: "",

  //   books: {
  //     bookId: " ",
  //     bookName: " ",
  //     genre: " ",
  //     bookAuthor: " ",
  //   },
  //   user: {
  //     userId: " ",
  //     userName: " ",
  //     userContact: " ",
  //   },
  // });

  useEffect(() => {
    // axios.get("http://localhost:1235/GetAllBorrow").then((res) => {
    //   console.log("Data", res.data);
    //   setBorrow(res.data);
    // });
    GetAllBorrowDetails();
  }, []);

  const GetAllBorrowDetails = async() =>{
    await axios.get("http://localhost:1235/GetAllBorrow").then((res) => {
      console.log("Data", res.data);
      setBorrow(res.data);
    });
  }
  

  const deleteBorrow = async(id) => {
    await axios.delete(`http://localhost:1235/deleteBorrowId/${id}`) 
    GetAllBorrowDetails();
  }

  return (
    <div>
      <div className="mt-5  ms-5 "></div>
      <div className="container mt-5 ">
        <table className=" table table-bordered p-4 mt-5">
          <tr className="border-5 bg-secondary  ">
            <th>Borrow ID</th>
            <th>Borrow Date</th>
            <th>Return Date</th>
            <th>Book Id</th>
            <th>User</th>
            <th>Delete</th>
          </tr>
          <tbody className="text-center ">
            {borrow.map((u) => (
              <tr key={u.borrowId}>
                <td>{u.borrowId}</td>
                <td>{u.borrowDate}</td>
                <td>{u.returnDate}</td>
                <td>{u.books ? u.books.bookName : "-"}</td>
                <td>{u.user ? u.user.userName : "-"}</td>

                <td>
                  <button
                    className="btn btn-danger mx-2"
                    onClick={() => deleteBorrow(u.borrowId)}
                  >
                   
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
