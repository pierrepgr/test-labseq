import { FormBuilder, FormGroup } from '@angular/forms';
import { LabseqService } from './labseq.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  form: FormGroup;

  result: string = '';

  constructor(
    private _formBuilder: FormBuilder,
    private labseqService: LabseqService){}


  ngOnInit(): void {
    this.createForm();
  }

  calculate() {
    this.labseqService.calculate(this.form.value.number)
      .subscribe(response => this.result = response)
  }

  private createForm() {
    this.form = this._formBuilder.group({
      number: ['']
    })
  }
}
