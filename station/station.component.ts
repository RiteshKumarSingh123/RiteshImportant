
import { Component, OnInit } from '@angular/core';
import { StationService } from '../station.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-station',
  templateUrl: './station.component.html',
  styleUrls: ['./station.component.css']
})
export class StationComponent implements OnInit {
 public stationName:any ;
 public stationList :any [] = [];
 public active :any;
 public name : any;
 public id : any;
 public activeSet : any;
 public stationPlatform : any;
 public totalTrainHaults : any;
 public numberOfExpress : any;
 public numberOfSuperFast : any;
 public numberOfLuxuryTrain : any;
 public staionConnectingWith : any;
 public editFlag : boolean = false;

  constructor(private service:StationService) { 
     this.getAllListData(this.active, this.stationName);
  }

  ngOnInit(): void {

  }


  public getAllListData(active: any, stationName: any) {
     active = active ? active : 1; 
     stationName = stationName ; 

    return this.service.getAllStationData(active, stationName).subscribe((res) => {
      this.stationList = res;
      console.log(this.stationList);
    });
  }

  public saveStationDetails(){
    let obj={
    'id' : 0,
    'stationName':this.name,
    'stationPlatform':this.stationPlatform,
    'totalTrainHaults':this.totalTrainHaults,
    'numberOfExpress':this.numberOfExpress,
    'numberOfSuperFast':this.numberOfSuperFast,
    'numberOfLuxuryTrain':this.numberOfLuxuryTrain,
    'staionConnectingWith':this.staionConnectingWith,
    'active':this.activeSet
    }
    return this.service.saveStationData(obj).subscribe(res=>{
      console.log(res);
      Swal.fire({
        icon: 'success',
        title: 'Success!',
        text: 'Data saved successfully.',
        timer: 2000,
        showConfirmButton: false
      });
     this.getAllListData(this.active, this.stationName);
     this.reset();
     },
    err => {
      console.error(err);
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Failed to save data. Please try again.'
      });
    }
  );
    
  }

  public reset(){
     this.name = null;
     this.stationPlatform = null;
     this.totalTrainHaults = null;
     this.numberOfExpress = null;
     this.numberOfSuperFast = null;
     this.numberOfLuxuryTrain = null;
    this.staionConnectingWith = null;
    this.activeSet = null;
  }

  public updateStationDetails(){
    let obj={
    'id':this.id,
    'stationName':this.name,
    'stationPlatform':this.stationPlatform,
    'totalTrainHaults':this.totalTrainHaults,
    'numberOfExpress':this.numberOfExpress,
    'numberOfSuperFast':this.numberOfSuperFast,
    'numberOfLuxuryTrain':this.numberOfLuxuryTrain,
    'staionConnectingWith':this.staionConnectingWith,
    'active':this.activeSet
    }
    return this.service.updateStationData(obj).subscribe(res=>{
      console.log(res);
       Swal.fire({
        icon: 'success',
        title: 'Success!',
        text: 'Data Updated successfully.',
        timer: 2000,
        showConfirmButton: false
      });
      this.getAllListData(this.active, this.stationName);
      this.reset();
   },
    err => {
      console.error(err);
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Failed to Update data. Please try again.'
      });
    }
  );
  }

  validation(){
    
    if (!this.name || this.name.trim() === '') {
         Swal.fire({
            icon: 'warning',
            title: 'Validation Error',
            text: 'Station Name cannot be empty'
        });
         return; 
    }

    if (!this.staionConnectingWith || this.staionConnectingWith.trim() === '') {
        Swal.fire({
            icon: 'warning',
            title: 'Validation Error',
            text: 'Station Connecting With cannot be empty'
        });
        return; 
    }

    // this.saveStationDetails();
    if (this.id && this.id > 0) {
        this.updateStationDetails();  
    } else {
        this.saveStationDetails();    
    }
  
  }

  public getStationDataByIds(id:any){ 
   this.id = id
   return this.service.getStationDataById(id).subscribe(response=>{
    this.name = response.stationName;
    this.stationPlatform = response.stationPlatform;
    this.totalTrainHaults = response.totalTrainHaults;
    this.numberOfExpress = response.numberOfExpress;
    this.numberOfSuperFast = response.numberOfSuperFast;
    this.numberOfLuxuryTrain = response.numberOfLuxuryTrain;
    this.staionConnectingWith = response.staionConnectingWith;
    this.activeSet = response.active;
   })
  }

  // public deleteStationById(id:any){
  //   id = id
  //   return this.service.getDeleteStationById(id).subscribe(res=>{
  //     console.log(res);
  //      this.getAllListData(this.active, this.stationName);
  //   })
  // }

  public deleteStationById(id: any) {
    id = id
  Swal.fire({
    title: 'Are you sure?',
    text: 'Do you want to delete this station?',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes, delete it!'
  }).then((result) => {
    if (result.isConfirmed) {
      this.service.getDeleteStationById(id).subscribe(res => {
        console.log(res);
        Swal.fire('Deleted!', 'The station has been deleted.', 'success');
        this.getAllListData(this.active, this.stationName);
      }, err => {
        Swal.fire('Error', 'Something went wrong while deleting.', 'error');
      });
    }
  });
}

}
