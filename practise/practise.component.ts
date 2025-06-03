import { Component, OnInit } from '@angular/core';
import { PractiseService } from '../practise.service';
@Component({
  selector: 'app-practise',
  templateUrl: './practise.component.html',
  styleUrls: ['./practise.component.css']
})
export class PractiseComponent implements OnInit {

  listOfHitachi :any[] = [];
  listOfBike :any[] = [];
  id: any;
  address: any ;
  companyName: any;
  name: any;
  price: any;
  rtoNumber: any;
  showRoomName: any;
  bike:any={};

  constructor(private service:PractiseService) { 
    // this.getListData();
    this.getBikeListData();
  }

  ngOnInit(): void {
  }

  // getListData(){
  // return this.service.getList().subscribe(response=>{
  //   this.listOfHitachi = response;
  //  console.log(response);
  // })
  // }

  getBikeListData(){
    return this.service.getBikeList().subscribe(listOfData=>{
    console.log(listOfData);
    this.listOfBike = listOfData;
    })
  }

  saveBike(){
 const obj={
  id: this.bike.id,
  address: this.bike.address,
  companyName: this.bike.companyName,
  name: this.bike.name,
  price: this.bike.price,
  rtoNumber: this.bike.rtoNumber,
  showRoomName: this.bike.showRoomName,
 }
 return this.service.saveBikeData(obj).subscribe(saveData=>{
  console.log(saveData);
  this.getBikeListData();
  this.bike ={};
 })
  }

  getBikeById(id:any){
    return this.service.getbikeId(id).subscribe(dataById=>{
      console.log(dataById);
    this.bike = dataById;
    })
  }

  deleteById(id:any){
    return this.service.deleteUsingId(id).subscribe(deleteResponse=>{
      console.log(deleteResponse);
      this.getBikeListData();
    })
  }

}
