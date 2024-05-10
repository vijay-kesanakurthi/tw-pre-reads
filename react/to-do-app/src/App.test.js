import { render, screen, fireEvent } from "@testing-library/react";
import App from "./App";

test("Should add a task to the list", () => {
  render(<App />);
  const taskInput = screen.getByPlaceholderText("Add a task");
  const addButton = screen.getByText("Add");
  const task = "Read SpringBoot";
  taskInput.value = task;
  fireEvent.click(addButton);
  expect(screen.getByText(task)).toBeInTheDocument();
});

test("Should not add a task to the list if the task is less than 3 characters", () => {
  render(<App />);
  const taskInput = screen.getByPlaceholderText("Add a task");
  const addButton = screen.getByText("Add");
  const task = "Re";
  taskInput.value = task;
  fireEvent.click(addButton);
  expect(screen.queryByText(task)).not.toBeInTheDocument();
});

test("Should mark a task as completed", () => {
  render(<App />);
  const taskInput = screen.getByPlaceholderText("Add a task");
  const addButton = screen.getByText("Add");
  const task = "Read SpringBoot";
  taskInput.value = task;
  fireEvent.click(addButton);
  const taskElement = screen.getByText(task);
  fireEvent.click(taskElement);
  expect(taskElement).toHaveClass("strike");
});

test("Should mark a task as pending", () => {
  render(<App />);
  const taskInput = screen.getByPlaceholderText("Add a task");
  const addButton = screen.getByText("Add");
  const task = "Read SpringBoot";
  taskInput.value = task;
  fireEvent.click(addButton);
  const taskElement = screen.getByText(task);
  fireEvent.click(taskElement);
  fireEvent.click(taskElement);
  expect(taskElement).not.toHaveClass("strike");
});

test("Should remove completed tasks from the list", () => {
  render(<App />);
  const taskInput = screen.getByPlaceholderText("Add a task");
  const addButton = screen.getByText("Add");
  const task = "Read SpringBoot";
  taskInput.value = task;
  fireEvent.click(addButton);
  const taskElement = screen.getByText(task);
  fireEvent.click(taskElement);
  const removeButton = screen.getByText("Remove Completed");
  fireEvent.click(removeButton);
  expect(screen.queryByText(task)).not.toBeInTheDocument();
});
