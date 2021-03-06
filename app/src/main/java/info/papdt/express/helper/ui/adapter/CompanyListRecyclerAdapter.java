package info.papdt.express.helper.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import info.papdt.express.helper.R;
import info.papdt.express.helper.api.KuaiDi100Helper;
import info.papdt.express.helper.ui.common.MyRecyclerViewAdapter;

public class CompanyListRecyclerAdapter extends MyRecyclerViewAdapter {

	private ArrayList<KuaiDi100Helper.CompanyInfo.Company> data;

	public CompanyListRecyclerAdapter(ArrayList<KuaiDi100Helper.CompanyInfo.Company> data) {
		this.data = data;
	}

	@Override
	public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.list_item_company, parent, false);
		ViewHolder holder = new ViewHolder(v);
		return holder;
	}

	@Override
	public void onBindViewHolder(ClickableViewHolder holder, int position) {
		if (!(holder instanceof ViewHolder)) return;

		super.onBindViewHolder(holder, position);

		ViewHolder h = (ViewHolder) holder;

		h.setTitle(data.get(position).name);
		if (data.get(position).phone != null) {
			h.tv_info.setVisibility(View.VISIBLE);
			h.tv_info.setText(data.get(position).phone);
		} else {
			if (data.get(position).website != null) {
				h.tv_info.setVisibility(View.VISIBLE);
				h.tv_info.setText(data.get(position).website);
			} else {
				h.tv_info.setVisibility(View.GONE);
			}
		}
	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	public KuaiDi100Helper.CompanyInfo.Company getItem(int pos) {
		return data.get(pos);
	}

	public class ViewHolder extends ClickableViewHolder {

		public CircleImageView iv_round;
		public TextView tv_name, tv_info, tv_center;

		public ViewHolder(View itemView) {
			super(itemView);
			iv_round = (CircleImageView) itemView.findViewById(R.id.iv_round);
			tv_name = (TextView) itemView.findViewById(R.id.tv_title);
			tv_info = (TextView) itemView.findViewById(R.id.tv_info);
			tv_center = (TextView) itemView.findViewById(R.id.center_text);
		}

		public void setTitle(String text) {
			tv_name.setText(text);
			tv_center.setText(text.substring(0, 1));
		}

	}

}
