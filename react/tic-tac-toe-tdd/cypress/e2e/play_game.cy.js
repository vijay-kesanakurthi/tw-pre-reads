describe("Testing Game", () => {
  it("should check the game", () => {
    cy.visit("http://localhost:3000");
    cy.get("[data-cy=game]").should("exist");
  });

  it("check the game title", () => {
    cy.visit("http://localhost:3000");
    cy.get("[data-cy=game]").should("contain.text", "Tic Tac Toe");
  });

  it("check the board", () => {
    cy.visit("http://localhost:3000");
    cy.get("[data-cy=board]").should("exist");
  });

  it("check the status", () => {
    cy.visit("http://localhost:3000");
    cy.get(".status").should("exist");
  });

  it("Click the square and check the status", () => {
    cy.visit("http://localhost:3000");
    cy.get("[data-cy=square]").first().click();
    cy.get(".status").should("contain.text", "Next player: O");
  });

  it("Click the square and check the square", () => {
    cy.visit("http://localhost:3000");
    cy.get("[data-cy=square]").first().click();
    cy.get("[data-cy=square]").first().should("have.text", "X");
  });

  it("Click two squares and check the status", () => {
    cy.visit("http://localhost:3000");
    cy.get("[data-cy=square]").first().click();
    cy.get(".status").should("contain.text", "Next player: O");
    cy.get("[data-cy=square]").eq(1).click();
    cy.get(".status").should("contain.text", "Next player: X");
  });

  it("Click two squares and check the squares", () => {
    cy.visit("http://localhost:3000");
    cy.get("[data-cy=square]").first().click();
    cy.get("[data-cy=square]").eq(1).click();
    cy.get("[data-cy=square]").first().should("have.text", "X");
    cy.get("[data-cy=square]").eq(1).should("have.text", "O");
  });

  it("Play the game and check the status(X wins)", () => {
    cy.visit("http://localhost:3000");
    cy.get("[data-cy=square]").first().click();
    cy.get("[data-cy=square]").eq(1).click();
    cy.get("[data-cy=square]").eq(3).click();
    cy.get("[data-cy=square]").eq(4).click();
    cy.get("[data-cy=square]").eq(6).click();

    cy.get(".status").should("contain.text", "Winner: X");
  });

  it("Play the game and check the status(O wins)", () => {
    cy.visit("http://localhost:3000");
    cy.get("[data-cy=square]").first().click();
    cy.get("[data-cy=square]").eq(1).click();
    cy.get("[data-cy=square]").eq(3).click();
    cy.get("[data-cy=square]").eq(4).click();
    cy.get("[data-cy=square]").eq(8).click();
    cy.get("[data-cy=square]").eq(7).click();
    cy.get(".status").should("contain.text", "Winner: O");
  });

  it("Play the game and check the status(Draw)", () => {
    cy.visit("http://localhost:3000");
    cy.get("[data-cy=square]").first().click();
    cy.get("[data-cy=square]").eq(4).click();
    cy.get("[data-cy=square]").eq(2).click();
    cy.get("[data-cy=square]").eq(1).click();
    cy.get("[data-cy=square]").eq(7).click();
    cy.get("[data-cy=square]").last().click();
    cy.get("[data-cy=square]").eq(3).click();
    cy.get("[data-cy=square]").eq(6).click();
    cy.get("[data-cy=square]").eq(5).click();
    cy.get(".status").should("contain.text", "Draw!");
  });
});
