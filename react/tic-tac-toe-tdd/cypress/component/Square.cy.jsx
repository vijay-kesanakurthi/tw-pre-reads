import Square from "../../src/components/Square";


describe('Square.cy.jsx', () => {
  it("should check square", () => {
    cy.mount(<Square value="X" onSquareClick={() => { }} />);
    cy.get("[data-cy=square]").should("have.text", "X");
  });

  it("should check square only once", () => {
    const onSquareClick = cy.stub();
    cy.mount(<Square value="X" onSquareClick={onSquareClick} />);
    cy.get("[data-cy=square]").click();
    cy.wrap(onSquareClick).should("have.been.calledOnce");
  });

});
