describe("Visit localhost:3000", () => {
  it("should create a message", () => {
    cy.visit("http://localhost:3000");
  });
});
