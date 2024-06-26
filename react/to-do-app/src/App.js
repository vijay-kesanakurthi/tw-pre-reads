import "./App.css";
import Header from "./Header/Header";
import SubHeader from "./SubHeader/SubHeader";
import ToDOItem from "./ToDoItem/ToDoItem";
import { useState } from "react";

const initialTodoList = [
  { task: "Read SpringBoot", status: "pending" },
  { task: "Complete assignments", status: "pending" },
  { task: "Prepare breakfast", status: "pending" },
  { task: "Sleep for 2 hours", status: "pending" },
  { task: "Take a shower", status: "pending" },
];

export default function App() {
  const [todoList, setTodoList] = useState(initialTodoList);
  const [newTask, setNewTask] = useState("");

  const handleClick = (id) => {
    setTodoList((e) =>
      e.map((todo, index) => {
        if (index === id) {
          if (todo.status === "pending") {
            return { ...todo, status: "completed" };
          } else {
            return { ...todo, status: "pending" };
          }
        }
        return todo;
      })
    );
  };
  function isTodoEmpty() {
    return todoList.length === 0;
  }

  return (
    <div className="App">
      <Header />
      <SubHeader />

      <div className="input-area">
        <input
          type="text"
          placeholder="Add a task"
          value={newTask}
          onChange={(e) => setNewTask(e.target.value)}
        />
        <button
          onClick={() => {
            newTask.length > 3 &&
              setTodoList((e) => [...e, { task: newTask, status: "pending" }]);
            setNewTask("");
          }}
        >
          Add
        </button>
      </div>
      <div className="todo-list">
        {todoList.map((todo, index) => (
          <ToDOItem
            key={index}
            data={todo}
            id={index}
            handleClick={handleClick}
          />
        ))}
        {isTodoEmpty() && <h3>Nothing to do buddy. Sleep!</h3>}
      </div>
      <br />
      {!isTodoEmpty() && (
        <button
          className="remove-completed"
          onClick={() => {
            setTodoList((e) => e.filter((todo) => todo.status === "pending"));
          }}
        >
          Remove Completed
        </button>
      )}
    </div>
  );
}
