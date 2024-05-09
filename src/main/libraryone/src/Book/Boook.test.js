import { render, screen } from "@testing-library/react";

import SearchBook from "./SearchBook";
import Nav from "../navbar/Nav";

const mockedNavigate = jest.fn();

jest.mock("react-router-dom", () => ({
  ...jest.requireActual("react-router-dom"),
  useNavigate: () => mockedNavigate,
}));

test("SearchBox", () => {
  render(<SearchBook />);
  const linkElement = screen.getByPlaceholderText(
    "Enter the Book Genre to search"
  );
  expect(linkElement).toBeInTheDocument();
});

describe("SearchBook component", () => {
  it("renders a select element with options", async () => {
    axios.get.mockResolvedValue({ data: ["Fantasy", "Romance", "Mystery"] });

    const { getByRole } = render(<SearchBook />);

    await waitFor(() => getByRole("searchbox"));

    const selectElement = getByRole("searchbox");
    expect(selectElement).toBeInTheDocument();
  });
});

const tableHead = screen.getByRole("table").tHead;
expect(tableHead).toBeInTheDocument();
const tableHeadCells = tableHead.rows[0].cells;
expect(tableHeadCells).toHaveLength(5);

test("renders the correct table data", () => {
  render(<SearchBook />);
  const linkElement = screen.getByText("No results");
  expect(linkElement).toBeInTheDocument();
});

test("renders the correct table data", () => {
  render(<SearchBook />);
  const linkElement = screen.getByText("No results");
  expect(linkElement).toBeInTheDocument();
});
