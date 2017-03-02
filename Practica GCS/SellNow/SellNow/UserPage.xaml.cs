using System;
using System.Collections.Generic;

using Xamarin.Forms;

namespace SellNow
{
	public partial class UserPage : ContentPage
	{
		public UserPage()
		{
			InitializeComponent();
		}

		async void OnModifyButtonClicked(object sender, EventArgs e)
		{
			await Navigation.PushAsync(new ProfilePage());
		}
	}
}
