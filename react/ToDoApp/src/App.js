import "./styles.css";
import Header from "./Header/Header";
import SubHeader from "./SubHeader/SubHeader";
import ToDOItem from "./ToDoItem/ToDoItem";

export default function App() {
  const todoList = [
    "Read SpringBoot",
    "Complete assignments",
    "Prepare breakfast",
    "Sleep for 2 hours",
    "Take a shower",
  ];
  return (
    <div className="App">
      <Header />
      <SubHeader />

      <hr />
      <div>
        {todoList.map((todo, index) => (
          <ToDOItem key={index} data={todo} />
        ))}
      </div>
    </div>
  );
}
