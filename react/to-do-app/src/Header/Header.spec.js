import { screen, render } from "@testing-library/react";

import Header from "./Header";

describe("Header", () => {
  it("should render the header text", () => {
    render(<Header />);
    const headerElement = screen.getByText(/Todo App/i);
    expect(headerElement).toBeInTheDocument();
  });
});
