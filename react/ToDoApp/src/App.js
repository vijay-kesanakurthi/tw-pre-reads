import "./styles.css";
import Header from "./Header/Header";
import Count from "./Count/Count";
import SubHeader from "./SubHeader/SubHeader";

export default function App() {
  return (
    <div className="App">
      <Header />
      <SubHeader />
      <Count data={0} />
      <hr />
      <div>“Nothing to do buddy. Sleep!!”</div>
    </div>
  );
}
