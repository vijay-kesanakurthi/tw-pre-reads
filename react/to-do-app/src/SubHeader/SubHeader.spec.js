import { screen, render } from "@testing-library/react";
import SubHeader from "./SubHeader";

describe("SubHeader", () => {
  it("should render the subheader text", () => {
    render(<SubHeader />);
    const subHeaderElement = screen.getByText(/A React App/i);
    expect(subHeaderElement).toBeInTheDocument();
  });
});
