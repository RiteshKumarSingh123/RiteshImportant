import { Component, OnInit } from '@angular/core';
import { MicroService } from '../micro.service';

@Component({
  selector: 'app-micro',
  templateUrl: './micro.component.html',
  styleUrls: ['./micro.component.css']
})
export class MicroComponent implements OnInit {

 public listOfMicros :any[] = [];
 public kawasakiListData :any[] = [];
 public tvsListData :any[] = [];
 public bajajListData :any[] = [];
 public yamahaListData :any[] = [];
 public heroListData :any[] = [];
 public hondaListData :any[] = [];
 public showRoomListData :any[] = [];
 public employeeListData :any[] = [];
 public showRoomName : any;
 public showRoomOwnerName : any;
 public totalEmployess : any;
 public departmentName : any;
 public ddepartment : any;
 public department : any;
 public  name : any;
 public  address : any;
 public salary : any;
 public micro : any ={};
 public teach : any = {};
 public departmentObj :any={};
 public employeeObj :any={};
 public showRoomObj :any={};
 public yamahaObj :any={};
 public kawasakiObj :any={};
 public tvsObj:any={};
 public bajajObj:any={};
 public hondaObj :any={};
 public heroObj:any={};
 public companyFrom :any;
 public managerName :any;
 public bestModel :any;
 public id : any;
 public sal : any;
 public showRoomId : any;
 public teacherList : any = [];
 public teacherId : any;
  constructor(private service:MicroService) {
  this.ListOfMicroData();
  this.teacherListingData();
   }

  ngOnInit(): void {
  }

  public ListOfMicroData(){
    return this.service.getAllMicroList().subscribe(list=>{
    this.listOfMicros = list.deptList;
    this.kawasakiListData = list.common.kawasakiList;
    this.tvsListData = list.common.tvsList;
    this.bajajListData = list.common.bajajList;
    this.yamahaListData = list.common.yamahaList;
    this.heroListData = list.common.heroList;
    this.hondaListData = list.common.hondaList;
    this.showRoomListData = list.common.showRoomList;
    this.employeeListData = list.employee;
    console.log(this.listOfMicros);
    })
  }

  public SaveMicroService(){
    let  obj={
      showRoomName:this.showRoomObj.showRoomName,
      showRoomOwnerName:this.showRoomObj.showRoomOwnerName,
      totalEmployess:this.showRoomObj.totalEmployess,
      "heroList":[{
          companyFrom:this.heroObj.companyFrom,
          managerName:this.heroObj.managerName,
          bestModel:this.heroObj.bestModel
      }],
      "bajajList":[{
          companyFrom:this.bajajObj.companyFrom,
          managerName:this.bajajObj.managerName,
          bestModel:this.bajajObj.bestModel
      }],
      "hondaList":[{
        companyFrom:this.hondaObj.companyFrom,
        managerName:this.hondaObj.managerName,
        bestModel:this.hondaObj.bestModel
      }],
      "kawasakiList":[{
        companyFrom:this.kawasakiObj.companyFrom,
        managerName:this.kawasakiObj.managerName,
        bestModel:this.kawasakiObj.bestModel
      }],
      "tvsList":[{
        companyFrom:this.tvsObj.companyFrom,
        managerName:this.tvsObj.managerName,
        bestModel:this.tvsObj.bestModel
      }],
      "yamahaList":[{
        companyFrom:this.yamahaObj.companyFrom,
        managerName:this.yamahaObj.managerName,
        bestModel:this.yamahaObj.bestModel
      }],
      "department":{
        departmentName:this.departmentObj.departmentName,
        department:this.departmentObj.department
    },
   "employee":{
    name:this.employeeObj.name,
    address:this.employeeObj.address,
    salary:this.employeeObj.salary
    }
  }
  return this.service.saveMicro(obj).subscribe(data =>{
   console.log(data);
   this.ListOfMicroData();
   this.showRoomObj.showRoomName='';
   this.showRoomObj.showRoomOwnerName='';
   this.showRoomObj.totalEmployess='';
   this.heroObj.companyFrom='';
   this.heroObj.managerName='';
   this.heroObj.bestModel='';
   this.bajajObj.companyFrom='';
   this.bajajObj.managerName='';
   this.bajajObj.bestModel='';
   this.hondaObj.companyFrom='';
   this.hondaObj.managerName='';
   this.hondaObj.bestModel='';
   this.kawasakiObj.companyFrom='';
   this.kawasakiObj.managerName='';
   this.kawasakiObj.bestModel='';
   this.tvsObj.companyFrom='';
   this.tvsObj.managerName='';
   this.tvsObj.bestModel='';
   this.yamahaObj.companyFrom='';
   this.yamahaObj.managerName='';
   this.yamahaObj.bestModel='';
   this.departmentObj.departmentName='';
   this.departmentObj.department='';
   this.employeeObj.name='';
   this.employeeObj.address='';
   this.employeeObj.salary='';
  })
  }

public getMicroById(showRoomId:any){
  // this.id = showRoomId;
  // alert(this.id);
return this.service.getMicroById(showRoomId).subscribe(res=>{
this.departmentObj = res.department;
this.employeeObj = res.employee;
this.showRoomObj = res.common.showRoomList[0];
this.kawasakiObj = res.common.kawasakiList[0];
this.tvsObj = res.common.tvsList[0];
this.bajajObj = res.common.bajajList[0];
this.yamahaObj = res.common.yamahaList[0];
this.heroObj = res.common.heroList[0];
this.hondaObj = res.common.hondaList[0];
this.id = res.common.showRoomList[0].showRoomId;
alert(this.id);
console.log(res);
this.updateShowData();
})
}

public deletById(showRoomId:any){
return this.service.deleteMicroById(showRoomId).subscribe(deletedResponse=>{
  console.log(deletedResponse);
  this.ListOfMicroData();
})
}

public updateMicroService(){
let obj={
  "department":{
    "id":this.departmentObj.id,
    "department":this.departmentObj.department,
    "departmentName":this.departmentObj.departmentName
},
"employee":{
    "id":this.employeeObj.id,
    "name":this.employeeObj.name,
    "address":this.employeeObj.address,
    "salary":this.employeeObj.salary
}
}
return this.service.updateMicro(obj).subscribe(res=>{
 console.log(res);
  this.ListOfMicroData();
  this.departmentObj={};
   this.employeeObj={};
})
}

public updateShowData() {
  alert(this.id);
  let obj = {
    showRoomId: this.showRoomObj.showRoomId,
    showRoomName: this.showRoomObj.showRoomName,
    showRoomOwnerName: this.showRoomObj.showRoomOwnerName,
    totalEmployess: this.showRoomObj.totalEmployess,
    heroList: [{
      companyFrom: this.heroObj.companyFrom,
      managerName: this.heroObj.managerName,
      bestModel: this.heroObj.bestModel
    }],
    bajajList: [{
      companyFrom: this.bajajObj.companyFrom,
      managerName: this.bajajObj.managerName,
      bestModel: this.bajajObj.bestModel
    }],
    hondaList: [{
      companyFrom: this.hondaObj.companyFrom,
      managerName: this.hondaObj.managerName,
      bestModel: this.hondaObj.bestModel
    }],
    kawasakiList: [{
      companyFrom: this.kawasakiObj.companyFrom,
      managerName: this.kawasakiObj.managerName,
      bestModel: this.kawasakiObj.bestModel
    }],
    tvsList: [{
      companyFrom: this.tvsObj.companyFrom,
      managerName: this.tvsObj.managerName,
      bestModel: this.tvsObj.bestModel
    }],
    yamahaList: [{
      companyFrom: this.yamahaObj.companyFrom,
      managerName: this.yamahaObj.managerName,
      bestModel: this.yamahaObj.bestModel
    }]
  };

  return this.service.updateShowRoom(obj).subscribe(res => {
    console.log(res);
    this.ListOfMicroData();
  });
}

public teacherListingData(){
return this.service.getTeacherLists().subscribe(res=>{
  this.teacherList = res;
  console.log(this.teacherList);
})
}

public saveTeachersData(){
  let obj={
    "name":this.teach.name,
    "sal":this.teach.sal,
    "address":this.teach.address
  }
  return this.service.saveTeachers(obj).subscribe(res=>{
    console.log(res);
    this.teacherListingData();
    // this.teach.name='';
    // this.teach.sal='';
    // this.teach.address='';
    this.teach={};
  })
}

public getTeachersById(id:any){

return this.service.getTeacherByIds(id).subscribe(res=>{
this.teach = res;
this.teacherId = res.id;
console.log(this.teach);
})
}

public updateTeacherData(){
  let obj={
    "id":this.teacherId,
    "name":this.teach.name,
    "sal":this.teach.sal,
    "address":this.teach.address
  }
  return this.service.updateTeachers(obj).subscribe(res=>{
    console.log(res);
    this.teacherListingData();
    // this.teach.name='';
    // this.teach.sal='';
    // this.teach.address='';
    this.teach={};
  })
}

public deleteTeachersById(id:any){
  return this.service.deleteTeachers(id).subscribe(res=>{
    console.log(res);
    this.teacherListingData();
  })
}

}
