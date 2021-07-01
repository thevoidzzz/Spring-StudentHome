console.log(Math.random()/100)

// Initialize and add the map
function initMap() {
  // The location of Uluru
  const uluru = { lat: -12.113710 + Math.random()/100, lng: -77.02954 + Math.random()/100};
  // The map, centered at Uluru
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 16,
    center: uluru,
  });
  // The marker, positioned at Uluru
  const marker = new google.maps.Marker({
    position: uluru,
    map: map,
  });
}
