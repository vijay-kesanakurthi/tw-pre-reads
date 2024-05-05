import { render, screen } from "@testing-library/react";
import Board from "./Board";
import { expect } from "@jest/globals";
import { act } from "react";

describe("Board", () => {
  it("should check the first player ", () => {
    render(<Board />);
    expect(screen.getByText("Next player: X")).toBeTruthy();
  });
  it("should check board", () => {
    render(<Board />);
    expect(screen.getAllByRole("button").length).toBe(9);
  });

  it("should check the status", () => {
    act(() => {
      render(<Board />);
    });
    const buttons = screen.getAllByRole("button");
    act(() => {
      buttons[0].dispatchEvent(new MouseEvent("click", { bubbles: true }));
    });
    expect(screen.getByText("Next player: O")).toBeTruthy();
  });

  it("Should check square only once", () => {
    act(() => {
      render(<Board />);
    });
    const buttons = screen.getAllByRole("button");
    act(() => {
      buttons[0].dispatchEvent(new MouseEvent("click", { bubbles: true }));
    });
    act(() => {
      buttons[0].dispatchEvent(new MouseEvent("click", { bubbles: true }));
    });
    expect(screen.getByText("X")).toBeTruthy();
  });
});

describe("Play the game", () => {
  it("should check the winner(X wins)", () => {
    act(() => {
      render(<Board />);
    });

    const buttons = screen.getAllByRole("button");
    let xWinningCombination = [0, 1, 3, 4, 6];

    xWinningCombination.forEach((button) => {
      act(() => {
        buttons[button].dispatchEvent(
          new MouseEvent("click", { bubbles: true })
        );
      });
    });

    expect(screen.getByText("Winner: X")).toBeTruthy();
  });

  it("should check the winner(O wins)", () => {
    act(() => {
      render(<Board />);
    });

    const buttons = screen.getAllByRole("button");
    let oWinningCombination = [0, 1, 3, 4, 8, 7];

    oWinningCombination.forEach((button, index) => {
      act(() => {
        buttons[button].dispatchEvent(
          new MouseEvent("click", { bubbles: true })
        );
      });
    });

    expect(screen.getByText("Winner: O")).toBeTruthy();
  });

  it("should check the draw", () => {
    act(() => {
      render(<Board />);
    });

    const buttons = screen.getAllByRole("button");
    let drawCombination = [0, 1, 2, 3, 5, 4, 6, 8, 7];

    drawCombination.forEach((button, index) => {
      act(() => {
        buttons[button].dispatchEvent(
          new MouseEvent("click", { bubbles: true })
        );
      });
    });

    expect(screen.getByText("Draw!")).toBeTruthy();
  });
});
