import Square from "./Square";
import { render, screen } from "@testing-library/react";
import { expect, jest } from "@jest/globals";
describe("Square", () => {
  it("should check square", () => {
    render(<Square value="X" onSquareClick={() => {}} />);
    expect(screen.getAllByText("X")).toBeTruthy();
  });

  it("should check square only once", () => {
    const onSquareClick = jest.fn();
    render(<Square value="X" onSquareClick={onSquareClick} />);
    const square = screen.getByRole("button");
    square.click();
    expect(onSquareClick).toHaveBeenCalledTimes(1);
  });
});
