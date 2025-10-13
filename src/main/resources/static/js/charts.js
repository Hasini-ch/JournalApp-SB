document.addEventListener("DOMContentLoaded", function () {
  const ctx = document.getElementById("moodChart");
  if (ctx) {
    new Chart(ctx, {
      type: "pie",
      data: {
        labels: ["Happy", "Sad", "Neutral", "Angry", "Excited"],
        datasets: [{
          label: "Mood Distribution",
          data: [12, 5, 7, 3, 9],
          backgroundColor: [
            "#4caf50",
            "#2196f3",
            "#ffeb3b",
            "#f44336",
            "#9c27b0"
          ]
        }]
      }
    });
  }
});