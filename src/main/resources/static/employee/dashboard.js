/* globals Chart:false, feather:false */

(function () {
  'use strict'

  feather.replace()

  // Graphs
  var ctx = document.getElementById('myChart')
  // eslint-disable-next-line no-unused-vars
  var myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: [
        'Sunday',
        'Monday',
        'Tuesday',
        'Wednesday',
        'Thursday',
        'Friday',
        'Saturday'
      ],
      datasets: [{
        data: [
          15339,
          21345,
          18483,
          24003,
          23489,
          24092,
          12034
        ],
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })
})()

$(document).ready(function(){
	$("#timeControlBtn").click(function() {
    if ($(this).hasClass('btn-success')) {
        $('#timeControlBtn').removeClass('btn-success').addClass('btn-danger');
        $(this).addClass('btn-primary').removeClass('btn-success');
        $(this).attr("name", "checkOut");
        $(this).val("Check-Out")
    } else if ($(this).hasClass('btn-primary')) {
        $('#timeControlBtn').removeClass('btn-danger').addClass('btn-success');
        $(this).addClass('btn-success').removeClass('btn-danger');
        $(this).attr("name", "checkIn");
        $(this).val("Check-In")
    }
})
});
