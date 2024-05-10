import { screen, render } from "@testing-library/react";
import ToDoItem from "./ToDoItem";

describe("ToDoItem", () => {
  it("should render the todo item", () => {
    const data = { task: "Read SpringBoot", status: "pending" };
    render(<ToDoItem data={data} id={0} handleClick={() => {}} />);
    const todoItemElement = screen.getByText(/Read SpringBoot/i);
    expect(todoItemElement).toBeInTheDocument();
  });

  it("should render the todo item with strike class", () => {
    const data = { task: "Read SpringBoot", status: "completed" };
    render(<ToDoItem data={data} id={0} handleClick={() => {}} />);
    const todoItemElement = screen.getByText(/Read SpringBoot/i);
    expect(todoItemElement).toHaveClass("strike");
  });
});
