<template>
  <!--  <div class="about">-->
  <!--    <h1>This is an about page</h1>-->
  <!--  </div>-->
  <div id="rooms">
    <div class="container">
      <div class="section-header">
        <h2>Apartments & Suites</h2>
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas in mi libero. Quisque convallis, enim at
          venenatis tincidunt.
        </p>
      </div>
      <div class="row">
        <div class="col-md-12 room" v-for="(key,index) in data" :key="data[index].id">
          <div class="row">
            <div class="col-md-6">
              <div class="room-img">
                <img src="../assets/img/room/room-1.jpg" alt="">
              </div>
            </div>
            <div class="col-md-6">
              <div class="room-des">
                <h3>Standard Single</h3>
                <h1>${{ key.price }}<span>/ Night</span></h1>
                <ul class="room-size">
                  <li><i class="fa fa-arrow-right"></i>Size: {{ key.area }} sq ft</li>
                  <li><i class="fa fa-arrow-right"></i>Beds: {{ key.bedNumber }} Single(s)</li>
                </ul>
                <ul class="room-icon">
                  <li class="icon-1"></li>
                  <li class="icon-2"></li>
                  <li class="icon-3"></li>
                  <li class="icon-4"></li>
                  <li class="icon-5"></li>
                  <li class="icon-6"></li>
                  <li class="icon-7"></li>
                  <li class="icon-8"></li>
                  <li class="icon-9"></li>
                  <li class="icon-10"></li>
                </ul>
                <div class="room-link">
                  <a href="#" data-toggle="modal" data-target="#modal-id">Read More</a>
                  <a href="#">Book Now</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>

export default {
  name: 'room',
  data () {
    return {
      data: [],
      key: {
        id: 'id',
        price: 'price',
        discount: 'discount',
        area: 'area',
        graphPath: 'graphPath',
        h_id: 'h_id',
        hotelName: 'hotelName',
        roomNumber: 'roomNumber',
        bedNumber: 'bedNumber',
        d: 1
      }
    }
  },
  created () {
    let id = this.$route.params.id
    let url = 'http://10.24.3.53:8181/findCurrentRooms?h_id=' + id
    let xmlhttp = new XMLHttpRequest()
    xmlhttp.open('Post', url, false)
    xmlhttp.send()
    const myData = xmlhttp.responseText
    this.data = JSON.parse(myData)
    console.log(this.data)
  },
  methods: {
  }
}

</script>

<style scoped>
#rooms {
  position: relative;
  padding: 45px 0 0 0;
  width: 100%;
  height: 1%;
}

#rooms .room {
  margin-bottom: 60px;
}

/*img0*/
#rooms .room-des {
  position: relative;
  top: 50%;
  transform: translate(20%, -130%);
}

#rooms .room-img {
  position: relative;
  top: 50%;
  transform: translate(-20%, 10%);
}

#rooms .room-des {
  width: 100%;
  text-align: center;
}

#rooms .room-img {
  border-radius: 30px;
  overflow: hidden;
}

#rooms .room-img img {
  border-radius: 30px;
  transition: 0.3s;
}

#rooms .room-img:hover img {
  -ms-transform: scale(1.2);
  -webkit-transform: scale(1.2);
  transform: scale(1.1);
}

#rooms .room-des h3 {
  font-size: 24px;
  margin-bottom: 15px;
}

@media (max-width: 768px) {
  #rooms .room-des h3 {
    margin-top: 15px;
  }
}

#rooms .room-des h1 {
  font-size: 45px;
  margin-bottom: 15px;
}

#rooms .room-des h1 span {
  margin-left: 5px;
  font-size: 14px;
  font-weight: 400;
}

/*img1*/
#rooms .room-des1 {
  position: relative;
  top: 50%;
  transform: translate(-20%, -230%);
}

#rooms .room-img1 {
  position: relative;
  top: 50%;
  transform: translate(20%, -60%);
}

#rooms .room-des1 {
  width: 100%;
  text-align: center;
}

#rooms .room-img1 {
  border-radius: 30px;
  overflow: hidden;
}

#rooms .room-img1 img {
  border-radius: 30px;
  transition: 0.3s;
}

#rooms .room-img1:hover img {
  -ms-transform: scale(1.2);
  -webkit-transform: scale(1.2);
  transform: scale(1.1);
}

#rooms .room-des1 h3 {
  font-size: 24px;
  margin-bottom: 15px;
}

@media (max-width: 768px) {
  #rooms .room-des1 h3 {
    margin-top: 15px;
  }
}

#rooms .room-des1 h1 {
  font-size: 45px;
  margin-bottom: 15px;
}

#rooms .room-des1 h1 span {
  margin-left: 5px;
  font-size: 14px;
  font-weight: 400;
}

/*img2*/
#rooms .room-des2 {
  position: relative;
  top: 50%;
  transform: translate(20%, -340%);
}

#rooms .room-img2 {
  position: relative;
  top: 50%;
  transform: translate(-20%, -130%);
}

#rooms .room-des2 {
  width: 100%;
  text-align: center;
}

#rooms .room-img2 {
  border-radius: 30px;
  overflow: hidden;
}

#rooms .room-img2 img {
  border-radius: 30px;
  transition: 0.3s;
}

#rooms .room-img2:hover img {
  -ms-transform: scale(1.2);
  -webkit-transform: scale(1.2);
  transform: scale(1.1);
}

#rooms .room-des2 h3 {
  font-size: 24px;
  margin-bottom: 15px;
}

@media (max-width: 768px) {
  #rooms .room-des2 h3 {
    margin-top: 15px;
  }
}

#rooms .room-des2 h1 {
  font-size: 45px;
  margin-bottom: 15px;
}

#rooms .room-des2 h1 span {
  margin-left: 5px;
  font-size: 14px;
  font-weight: 400;
}

/*img3*/
#rooms .room-des3 {
  position: relative;
  top: 50%;
  transform: translate(-20%, -440%);
}

#rooms .room-img3 {
  position: relative;
  top: 50%;
  transform: translate(20%, -190%);
}

#rooms .room-des3 {
  width: 100%;
  text-align: center;
}

#rooms .room-img3 {
  border-radius: 30px;
  overflow: hidden;
}

#rooms .room-img3 img {
  border-radius: 30px;
  transition: 0.3s;
}

#rooms .room-img3:hover img {
  -ms-transform: scale(1.2);
  -webkit-transform: scale(1.2);
  transform: scale(1.1);
}

#rooms .room-des3 h3 {
  font-size: 24px;
  margin-bottom: 15px;
}

@media (max-width: 768px) {
  #rooms .room-des3 h3 {
    margin-top: 15px;
  }
}

#rooms .room-des3 h1 {
  font-size: 45px;
  margin-bottom: 15px;
}

#rooms .room-des3 h1 span {
  margin-left: 5px;
  font-size: 14px;
  font-weight: 400;
}

/*img4*/
#rooms .room-des4 {
  position: relative;
  top: 50%;
  transform: translate(20%, -540%);
}

#rooms .room-img4 {
  position: relative;
  top: 50%;
  transform: translate(-20%, -260%);
}

#rooms .room-des4 {
  width: 100%;
  text-align: center;
}

#rooms .room-img4 {
  border-radius: 30px;
  overflow: hidden;
}

#rooms .room-img4 img {
  border-radius: 30px;
  transition: 0.3s;
}

#rooms .room-img4:hover img {
  -ms-transform: scale(1.2);
  -webkit-transform: scale(1.2);
  transform: scale(1.1);
}

#rooms .room-des4 h3 {
  font-size: 24px;
  margin-bottom: 15px;
}

@media (max-width: 768px) {
  #rooms .room-des4 h3 {
    margin-top: 15px;
  }
}

#rooms .room-des4 h1 {
  font-size: 45px;
  margin-bottom: 15px;
}

#rooms .room-des4 h1 span {
  margin-left: 5px;
  font-size: 14px;
  font-weight: 400;
}

#rooms .room-size {
  margin: 0 0 25px 0;
  padding: 0;
}

.section-header {
  position: relative;
  max-width: 700px;
  margin: 0 auto;
  text-align: center;
  margin-bottom: 45px;
  padding-bottom: 15px;
}

.section-header h2 {
  font-size: 45px;
  font-weight: 700;
  letter-spacing: 1px;
  margin-bottom: 15px;
}

.section-header p {
  margin: 0;
  font-size: 18px;
  font-weight: 300;
  line-height: 25px;
}

#rooms .room-size li {
  display: inline-block;
  font-size: 14px;
  margin-right: 15px;
  list-style-type: none;
}

#rooms .room-size li i {
  margin-right: 6px;
}

#rooms .room-icon {
  margin: 0;
  padding: 0;
  position: relative;
  width: 100%;
}

#rooms .room-icon li {
  list-style-type: none;
  display: inline-block;
  width: 30px;
  height: 30px;
  margin-right: 15px;
  margin-bottom: 15px;
  cursor: pointer;
  background-repeat: no-repeat;
  background-size: contain;
  transition: 0.5s;
}

@media (max-width: 576px) {
  #rooms .room-icon li {
    width: 20px;
    height: 20px;
    margin-right: 10px;
    margin-bottom: 10px;
  }
}

#rooms .room-icon li.icon-1 {
  background-image: url(../assets/img/icon/shield.png);
}

#rooms .room-icon li.icon-1:hover {
  background-image: url(../assets/img/icon/shield-hover.png);
}

#rooms .room-icon li.icon-2 {
  background-image: url(../assets/img/icon/air-conditioner.png);
}

#rooms .room-icon li.icon-2:hover {
  background-image: url(../assets/img/icon/air-conditioner-hover.png);
}

#rooms .room-icon li.icon-3 {
  background-image: url(../assets/img/icon/bathtub.png);
}

#rooms .room-icon li.icon-3:hover {
  background-image: url(../assets/img/icon/bathtub-hover.png);
}

#rooms .room-icon li.icon-4 {
  background-image: url(../assets/img/icon/shower.png);
}

#rooms .room-icon li.icon-4:hover {
  background-image: url(../assets/img/icon/shower-hover.png);
}

#rooms .room-icon li.icon-5 {
  background-image: url(../assets/img/icon/towel.png);
}

#rooms .room-icon li.icon-5:hover {
  background-image: url(../assets/img/icon/towel-hover.png);
}

#rooms .room-icon li.icon-6 {
  background-image: url(../assets/img/icon/television.png);
}

#rooms .room-icon li.icon-6:hover {
  background-image: url(../assets/img/icon/television-hover.png);
}

#rooms .room-icon li.icon-7 {
  background-image: url(../assets/img/icon/wifi.png);
}

#rooms .room-icon li.icon-7:hover {
  background-image: url(../assets/img/icon/wifi-hover.png);
}

#rooms .room-icon li.icon-8 {
  background-image: url(../assets/img/icon/call.png);
}

#rooms .room-icon li.icon-8:hover {
  background-image: url(../assets/img/icon/call-hover.png);
}

#rooms .room-icon li.icon-9 {
  background-image: url(../assets/img/icon/minibar.png);
}

#rooms .room-icon li.icon-9:hover {
  background-image: url(../assets/img/icon/minibar-hover.png);
}

#rooms .room-icon li.icon-10 {
  background-image: url(../assets/img/icon/kitchen.png);
}

#rooms .room-icon li.icon-10:hover {
  background-image: url(../assets/img/icon/kitchen-hover.png);
}

#rooms .room-link {
  position: relative;
  width: 100%;
  margin-top: 5px;
}

#rooms .room-link a {
  display: inline-block;
  padding: 7px 30px;
  color: #00CED1;
  border-radius: 30px;
  background: #222222;
}

#rooms .room-link a:first-child {
  margin-right: 15px;
}

#rooms .room-link a:hover {
  color: #222222;
  background: #00CED1;
}
</style>
