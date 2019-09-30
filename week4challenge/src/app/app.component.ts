import { Component } from '@angular/core';
import { NumberSymbol } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'week4challenge';
  numbers: number[] =null;
  sortedNumbers:number[]=null;
  number: number=42;
   vars="hello";
  sort(){
    
   this.sortedNumbers=this.numbers.sort();
  console.log(this.sortedNumbers);
  }
}

