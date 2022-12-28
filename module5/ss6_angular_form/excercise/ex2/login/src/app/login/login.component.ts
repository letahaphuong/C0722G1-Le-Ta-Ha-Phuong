import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  contactForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])
  })

  get email(){
    return this.contactForm.get('email');
  }
  get password(){
    return this.contactForm.get('password');
  }
  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.contactForm.value);
  }
  displayStyle = "none";
  openPopup() {
    this.displayStyle = "block";
  }

  closePopup() {
    this.displayStyle = "none";
  }
}
