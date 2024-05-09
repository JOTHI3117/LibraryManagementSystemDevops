import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import axios from "axios";

function SearchBook() {
  // const [bookGenreList, setBookGenreList] = useState([]);
  const [displaybookGenreList, setDisplayBookGenreList] = useState([]);
  const [search, setSearch] = useState("");
  // const navigate = useNavigate();

  const [bookedId, setBookedId] = useState(0);

  useEffect(() => {
    
    getAllBook();
  }, []);

  async function getAllBook() {
    try {
       await axios
        .get("http://localhost:1235/GetAllBookDetails")
        .then((res) => {
          console.log(res.data);
          setDisplayBookGenreList(res.data);
        })
        
    } catch (err) {
      
    }
  }

  // const add = (bookId) => {
  //   axios.delete(``).then((res) => console.log(res));
  //   window.location.reload();
    
  // };

  // const [books, setBooks] = useState({
  //   bookId: " ",
  //   bookName: " ",
  //   genre: "",
  //   bookAuthor: " ",
  //   borrow: {
  //     borrowId: " ",
  //     borrowDate: " ",
  //     returnDate: " ",
  //   },
  //   user: {
  //     userId: " ",
  //     userName: " ",
  //     userContact: " ",
  //   },
  // });

  const filterBook = displaybookGenreList.filter((book) => {
    return book.genre.toLowerCase().includes(search.toLowerCase());
  });

  // const onInputChange = (e) => {
  //   setBooks({ ...books, [e.target.name]: e.target.value });
  // };

  const [borrow, setBorrow] = useState({
    books: {
      bookId: 0,
    },
    user: {
      userId: 4,
    },
  });
  const Add = (id) => {
    console.log(id);
    setBorrow({ ...borrow, books: { bookId: id } });
    console.log(borrow);
    handleBorrow(id);
  };

  const handleBorrow = (id) => {
    console.log("borrow : " + borrow);
    axios
      .post("http://localhost:1235/AddBorrow", borrow)
      .then((res) => {
        console.log(res.data);
        setBookedId(id);
        console.log(bookedId);
       
      })
      .catch((err) => console.log(err));
  };

  return (
    <div class="container m-5 ">
      <div class="row mt-5   ">
        
        <div class="col-5 ">
          <input
            data-testid="searchbox"
            id="search"
            type="text"
            class="form-control"
            placeholder="Enter the Book Genre to search"
            role="searchbox"
            value={search}
            onChange={(e) => setSearch(e.target.value)}
          />
        </div>
      </div>

      <div>
        <form class="form-inline">
          <div class="form-group">
            {filterBook.length > 0 ? (
              <table role="table" className="table table-bordered p-4 mt-5" >
                <tr  className="border-5 bg-secondary ">
                  <th role="row">Book ID</th>
                  <th>Book Name</th>
                  <th>Book genre</th>
                  <th>Book Author</th>
                 
                  <th>Click to Borrow</th>
                </tr>
                <tbody className="text-center ">
                  {filterBook.map((u) => (
                    <tr key={u.bookId}>
                      <td>{u.bookId}</td>
                      <td>{u.bookName}</td>
                      <td>{u.genre}</td>
                      <td>{u.bookAuthor}</td>

                      <td>
                        <button
                        // role="button"
                          type="button"
                          onClick={() => {
                            Add(u.bookId);
                          }}
                          class={
                          
                               "btn btn-success"
                          }
                        >
                          Borrow Book
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            ) : (
             
              <h3 id="result" className="mt-lg-5 " style={{ color: "red" }}>
                No results
              </h3>
            )}
          </div>
        </form>
      </div>
    </div>
  );
}

export default SearchBook;
