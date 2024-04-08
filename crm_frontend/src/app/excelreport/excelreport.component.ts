import { Component } from '@angular/core';
import { SignupService } from '../signup.service';
import * as XLSX from 'xlsx';
import { ToastrService } from 'ngx-toastr';
 
@Component({
  selector: 'app-excelreport',
  templateUrl: './excelreport.component.html',
  styleUrls: ['./excelreport.component.css']
})
export class ExcelreportComponent {
  Contacts: any[] = [];
  userId: number | undefined;
  showDownloadButton: boolean = false;
  currentPage: number = 1;
  pageSize: number = 5; // Adjusted the page size to 5
  totalRecords: number = 0;
  selectedFormat: string = 'csv'; // Default selected format
  fetchingData: boolean = false; // Indicates whether data is being fetched
  fetchedData: boolean = false; // Indicates whether data has been fetched successfully
 
  constructor(private api: SignupService,  private toast: ToastrService) {}
 
  fetchContacts(): void {
    if (this.userId !== undefined) {
      this.fetchingData = true; // Set fetchingData to true when data is being fetched
      this.api.getContacts(this.userId).subscribe(
        (data: any[]) => {
          this.totalRecords = data.length;
          this.showDownloadButton = this.totalRecords > 0; // Show download button only if there are records
          this.updateContacts(data);
          
          this.fetchedData = true; // Set fetchedData to true when data is fetched successfully
          this.fetchingData = false; // Set fetchingData to false after data retrieval
          ;
        
        },
        (error: any) => {
          console.error('Error fetching contacts:', error);
          this.showDownloadButton = false; // Hide the download button
          this.fetchedData = false; // Set fetchedData to false when there's an error
          this.fetchingData = false; // Set fetchingData to false after data retrieval
          this.toast.error("Error fetching contacts")
        
        }
      );
    } else {
      console.error('User ID is not provided.');
      this.showDownloadButton = false; // Hide the download button
      this.fetchedData = false; // Set fetchedData to false when user ID is not provided
      this.toast.error("User ID is not provided")

    }
  }
 
  updateContacts(data: any[]): void {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = Math.min(startIndex + this.pageSize, this.totalRecords);
    this.Contacts = data.slice(startIndex, endIndex);
  }
 
  nextPage(): void {
    if (this.userId !== undefined && (this.currentPage * this.pageSize) < this.totalRecords) {
      this.currentPage++;
      this.fetchContacts();
    }
  }
 
  prevPage(): void {
    if (this.userId !== undefined && this.currentPage > 1) {
      this.currentPage--;
      this.fetchContacts();
    }
  }
 
  downloadContacts(): void {
    if (this.userId !== undefined) {
      this.api.getContacts(this.userId).subscribe(
        (data: any[]) => {
          if (this.selectedFormat === 'csv') {
            this.downloadAsCsv(data);
            this.toast.success("Data downloaded successfully   CSV format" )
          } else if (this.selectedFormat === 'excel') {
            this.downloadAsExcel(data);
            this.toast.success("Data downloaded successfully   Excel format" )
          } else {
            console.error('Invalid format selected.');
          }
        },
        (error: any) => {
          console.error('Error fetching contacts for download:', error);
        }
      );
    } else {
      console.error('User ID is not provided.');
    }
  }
 
  downloadAsCsv(data: any[]): void {
    const csvData = this.convertToCsv(data);
    const blob = new Blob([csvData], { type: 'text/csv' });
    const url = window.URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = 'contacts.csv';
    document.body.appendChild(a);
    a.click();
    window.URL.revokeObjectURL(url);
    document.body.removeChild(a);
  }
 
  downloadAsExcel(data: any[]): void {
    const worksheet: XLSX.WorkSheet = XLSX.utils.json_to_sheet(data);
    const workbook: XLSX.WorkBook = { Sheets: { 'data': worksheet }, SheetNames: ['data'] };
    const excelBuffer: any = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });
    this.saveAsExcelFile(excelBuffer, 'contacts');
  }
 
  saveAsExcelFile(buffer: any, fileName: string): void {
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
 
  convertToCsv(data: any[]): string {
    const headers = Object.keys(data[0]).join(',') + '\n';
    const rows = data.map(obj => Object.values(obj).join(',') + '\n').join('');
    return headers + rows;
  }
}