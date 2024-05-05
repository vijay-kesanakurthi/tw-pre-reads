import { render, screen } from "@testing-library/react";
import App from "./App";

describe("App", () => {
  it("should check the title", () => {
    render(<App />);
    expect(screen.getByText("Tic Tac Toe")).toBeTruthy();
  });
});
