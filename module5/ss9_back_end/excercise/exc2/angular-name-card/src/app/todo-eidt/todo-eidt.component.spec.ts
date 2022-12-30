import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TodoEidtComponent } from './todo-eidt.component';

describe('TodoEidtComponent', () => {
  let component: TodoEidtComponent;
  let fixture: ComponentFixture<TodoEidtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TodoEidtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TodoEidtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
