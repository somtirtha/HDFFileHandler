package com.somtirtha.hdfhandler;

import hdf.hdf5lib.H5;
import hdf.hdf5lib.HDF5Constants;
import hdf.hdflib.HDFLibrary;
//import hdf.hdf.H4File;

import java.io.File;
import java.io.IOException;

public class HDFFileHandler {
	
	public void print2DArray(int[][] arr) {
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[0].length; ++j) {
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println("\n");
		}
	}

	public void readHDF5(String fileName) {

		try {
			// open file and retrieve the file structure
			int file_id = -1;
			int dataset_id = -1;
			int faplist_id;
			int status;

			// Open the HDF5 file
			// faplist_id = H5.H5Pcreate(HDF5Constants.H5P_FILE_ACCESS);
			file_id = H5.H5Fopen(fileName, HDF5Constants.H5F_ACC_RDONLY, HDF5Constants.H5P_DEFAULT);

			System.out.println(file_id);

			/* Open an existing dataset. */
			dataset_id = H5.H5Dopen(file_id, "/DS1", 0);

			/*
			 * read the entire dataset, into 'dset_data': memory type is 'native int' read
			 * the entire dataspace to the entire dataspace, no transfer properties,
			 */
			int[][] dset_data = new int[32][64];
			status = H5.H5Dread(dataset_id, HDF5Constants.H5T_NATIVE_INT, HDF5Constants.H5S_ALL, HDF5Constants.H5S_ALL,
					HDF5Constants.H5P_DEFAULT, dset_data);

			status = H5.H5Dclose(dataset_id);

			// print data; this is to test teh data we read from 
			print2DArray(dset_data);

			// close the file using the file id
			H5.H5Fclose(file_id);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
	
	
	/**
	 * Read HDF4 file
	 * WORKING ON THIS FUNCTION
	 * @param fileName
	 */

	public void readHDF4(String fileName) {
		try {
			// open file and retrieve the file structure
			int file_id = -1;
			int dataset_id = -1;
			int faplist_id;
			int status;

			// Open the HDF5 file
//			faplist_id = H5.H5Pcreate(HDF5Constants.H5P_FILE_ACCESS);
//			status = H5.H5Pset_fapl_stdio(faplist_id);
			short n_dds = 0;
			file_id = HDFLibrary.HDFopen(fileName, HDF5Constants.H5F_ACC_RDONLY, n_dds);

			System.out.println(file_id);

			/* Open an existing dataset. */
//			dataset_id = HDFLibrary.HDDopen(file_id, "/DS1", 0);

			/*
			 * read the entire dataset, into 'dset_data': memory type is 'native int' read
			 * the entire dataspace to the entire dataspace, no transfer properties,
			 */
			

			// print data


			// close the file using the file id
			HDFLibrary.HDFclose(file_id);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public static void extractHDF4Data() {

	}
}
