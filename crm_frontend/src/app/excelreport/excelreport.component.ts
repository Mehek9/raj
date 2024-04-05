import { Component } from '@angular/core';
import { SignupService } from '../signup.service';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-excelreport',
  templateUrl: './excelreport.component.html',
  styleUrls: ['./excelreport.component.css']
})
export class ExcelreportComponent {
  Contacts: any[] = [];
  userId: number | undefined;
  showDownloadButton: boolean = false;

  constructor(private api: SignupService) {}

  fetchContacts(): void {
    if (this.userId) {
      this.api.getContacts(this.userId).subscribe(
        (data: any) => {
          this.Contacts = data;
          this.showDownloadButton = true; // Set the flag to show the download button
        },
        (error: any) => {
          console.error('Error fetching contacts:', error);
        }
      );
    } else {
      console.error('User ID is not provided.');
    }
  }

  downloadExcel(): void {
    const worksheet: XLSX.WorkSheet = XLSX.utils.json_to_sheet(this.Contacts);
    const workbook: XLSX.WorkBook = { Sheets: { 'data': worksheet }, SheetNames: ['data'] };
    const excelBuffer: any = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });
    this.saveAsExcelFile(excelBuffer, 'contacts');
  }

  private saveAsExcelFile(buffer: any, fileName: string): void {
    const data: Blob = new Blob([buffer], { type: 'application/octet-stream' });
    const a: HTMLAnchorElement = document.createElement('a');
    document.body.appendChild(a);
    const url: string = window.URL.createObjectURL(data);
    a.href = url;
    a.download = fileName + '.xlsx';
    a.click();
    window.URL.revokeObjectURL(url);
    document.body.removeChild(a);
  }
}
