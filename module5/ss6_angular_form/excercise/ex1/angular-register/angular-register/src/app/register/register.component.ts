import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Country} from '../../model/country';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  // tslint:disable-next-line:typedef
  get password() {
    return this.contactForm.get('password');
  }

  // tslint:disable-next-line:typedef
  get confirmPassword() {
    return this.contactForm.get('confirmPassword');
  }

  constructor(private formBuilder: FormBuilder) {
  }
  countrys: Country[] = [
    {
      id: 1,
      name: 'Việt Nam'
    },
    {
      id: 2,
      name: 'Lào'
    },
    {
      id: 3,
      name: 'Thái lan'
    }
  ];
  contactForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)]),
    country: new FormControl(),
    age: new FormControl('', [Validators.required, Validators.min(18)]),
    gender: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')])
  });

//   passwordForm= new FormGroup({
//     password: new FormControl(),
//     confirmPassword: new FormControl(),
//     {validator: this.ConfirmedValidator('password', 'confirmPassword')}
//   })
  passwordForm = this.formBuilder.group(
    {
      password: this.password,
      confirmPassword: this.confirmPassword,
    }
    ,
    {
      validator: this.ConfirmedValidator('password', 'confirmPassword'),
    }
  );
  // tslint:disable-next-line:typedef
  ConfirmedValidator(controlName: string, matchingControlName: string) {
    return (formGroup: FormGroup) => {
      const control = formGroup.controls[controlName];
      const matchingControl = formGroup.controls[matchingControlName];
      if (
        matchingControl.errors &&
        !matchingControl.errors.confirmedValidator
      ) {
        return;
      }
      if (control.value !== matchingControl.value) {
        matchingControl.setErrors({confirmedValidator: true});
      } else {
        matchingControl.setErrors(null);
      }
    };
  }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    console.log(this.contactForm.value);
  }
}
